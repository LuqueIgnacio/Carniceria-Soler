import {
    Routes,
    Route
  } from "react-router-dom";

import Home from "./Home"
import Login from "./Login"
import Register from "./Register"
import Commercialization from "./Commercialization"
import Shop from "./Shop"
import About from "./About"
import Contact from "./Contact"
import Legal from "./Legal"
  
function Router(){
    return(
        <Routes>
            <Route path="/" element={ <Home/>}/>
            <Route path="/nosotros" element={<About/>}/>    
            <Route path="/contacto" element={<Contact/>}/>    
            <Route path="/comercializacion" element={ <Commercialization/>}/>    
            <Route path="/legales" element={<Legal/>}/>    
            <Route path="/tienda" element={ <Shop/>}/>    
            <Route path="/login" element={ <Login/>}/>
            <Route path="/registro" element={ <Register/>}/>
        </Routes>
    )
}

export default Router