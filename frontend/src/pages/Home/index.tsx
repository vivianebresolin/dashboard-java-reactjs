import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

export default function Home() {
    return (
        <>
            <NavBar />
            <div className="content container">
                <div>
                    <h1>DSVendas</h1>
                    <h4> Analise o desempenho das suas vendas por diferentes perspectivas</h4>
                    <hr />
                    <p> Esta aplicação consiste em exibir um dashboard a partir de dados fornecidos por um backend construído com Spring Boot.</p>
                    <Link className="button" to="/dashboard">
                        Acessar dashboard
                    </Link>
                </div>
            </div>
            <Footer />
        </>
    );
}