import BarChart from "components/BarChart";
import DonutChart from "components/DonutChart";
import NavBar from "components/NavBar";
import DataTable from "components/DataTable";

export default function Dashboard() {
    return (
        <>
            <NavBar />
            <div className="dashboard container">
                <h1 className="text-center text-primary mt-1 mb-5">Dashboard de vendas</h1>

                <div className="row px-3 mb-5">
                    <div className="col-sm-6">
                        <h5 className="text-center">Taxa de sucesso (%)</h5>
                        <BarChart />
                    </div>
                    <div className="col-sm-6">
                        <h5 className="text-center">Total de vendas por vendedor (%)</h5>
                        <DonutChart />
                    </div>
                </div>
            </div>
            <DataTable />
        </>
    );
}