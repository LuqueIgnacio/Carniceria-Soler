import "./css/bootstrap.min.css"
import './App.css';
import './css/Utilities.css';
import Header from './pages/public/Header'
import Router from "./pages/public/Router";
import Footer from "./pages/public/Footer"
import { CartContextProvider } from "./context/CartContext";


function App() {

  return (
    <>
      <CartContextProvider>
        <Header/>
        <Router/>
      </CartContextProvider>
      <Footer/>
    </>
  )
}

export default App
