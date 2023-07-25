import "../../css/Footer.css"
import {Link } from "react-router-dom";

function Footer(){
    return(
        <footer className="footer">
            <div className="contenedor">
                <div className="primer-footer">
                    <div className="logo">
                        <h1><span className="rojo">Carnicería</span> y <span className="dorado">Kiosco</span> <br/>Soler</h1>
                    </div>
                    <div className="need-help">
                        <h3>Necesitas ayuda?</h3>
                        <a href="">Call to Order: 1-877-624-6898</a>
                    </div>
                </div>
                <div className="nav">
                
                        <Link to="/tienda">Productos</Link>
                        <Link to="/nosotros">Quienes Somos</Link>
                        <Link to="/contacto">Contactanos</Link>
                        <Link to="/legales">Términos y Condiciones</Link>
        
                </div>
            </div>  
        </footer>
    )
}

export default Footer