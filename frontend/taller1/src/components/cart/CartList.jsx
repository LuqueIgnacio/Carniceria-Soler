import React from "react"
import Product from "../../components/cart/Product"
import { useCart } from "../../hooks/useCart"

const CartList = (props) =>{

    const {children, products} = props
    const {deleteProduct, addProduct} = useCart()
   
    return(
        <div class="carrito-productos">
        {children.length == 0 ? (
             <>
             <p>El carrito aún está vacío</p>
             <p>¡Empieza a llenarlo!</p>
             </>
        ):children}
        </div>
    )
}

export default CartList