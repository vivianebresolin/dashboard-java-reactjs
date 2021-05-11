import axios from 'axios';
import { Loading } from 'components/Loading';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleTotalPerSeller } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[],
    series: number[]
}

export default function DonutChart() {
    const [loading, setLoading] = useState(true);
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/total-per-seller`)
            .then(response => {
                const data = response.data as SaleTotalPerSeller[];
                const myLabels = data.map(item => item.sellerName);
                const mySeries = data.map(item => item.total);

                setChartData({ labels: myLabels, series: mySeries });
            })
            .then(() => setLoading(false));
    }, []);

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <>
            { loading ? (<Loading />) :
                (
                    <Chart
                        options={{ ...options, labels: chartData.labels }}
                        series={chartData.series}
                        type="donut"
                        height="240"
                        className="donut-chart"
                    />
                )}
        </>
    );
}