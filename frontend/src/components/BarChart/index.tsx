import Chart from 'react-apexcharts';
import { useEffect, useState } from 'react';
import { ConversionRatePerSeller } from 'types/sale';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import { round } from 'utils/format';

type SeriesData = {
    name: string,
    data: number[]
}

type ChartData = {
    labels: {
        categories: string[],
    },
    series: SeriesData[]
}

export default function BarChart() {
    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: [],
        },
        series: [
            {
                name: "",
                data: []
            }
        ],
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/conversion-rate-per-seller`)
            .then(response => {
                const data = response.data as ConversionRatePerSeller[];
                const myLabels = data.map(item => item.sellerName);
                const mySeries = data.map(item => round(100.0 * item.deals / item.visited, 1));

                setChartData({
                    labels: {
                        categories: myLabels,
                    },
                    series: [
                        {
                            name: "% Sucesso",
                            data: mySeries
                        }
                    ]
                });
            });
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"
            className="bar-chart"
        />
    );
}