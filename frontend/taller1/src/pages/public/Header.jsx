import "../../css/Header.css"
import React from "react"
import { Link} from "react-router-dom";
import Cart from "../../components/cart/Cart"

function Header(){
    
    return (
        <>
            <div className="mensaje"><p>Ofertas todos los viernes</p></div>
            <header>
                <div className="logo">
                    <h1>
                        <a to="/">
                            <span className="rojo">Carnicería</span> y <span className="dorado">Kiosco</span> <br/>Soler
                        </a>
                    </h1>
                </div>
                <nav className="nav">
                    <Link to="tienda">Productos</Link>
                    <Link to="/nosotros">Quienes Somos</Link>
                    <Link to="/contacto">Contactanos</Link>
                    <Link to="/comercializacion">Comercialización</Link>
                    <Link to="/login">Iniciar Sesión</Link>
                    <Link to="/registro">Registrarse</Link>
                    <Link to="/admin" >Admin</Link>
                    <Cart/>
                </nav>
            </header>
        </>
    )
}

export default Header