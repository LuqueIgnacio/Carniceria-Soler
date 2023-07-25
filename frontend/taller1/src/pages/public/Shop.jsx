import "../../css/Tienda.css"
import React from "react"
import Seeker from "../../components/shop/Seeker"
import Product from "../../components/shop/Product"
import {useGetProductsToSale} from "../../hooks/ProductsHooks"
import { useCart } from "../../hooks/useCart"

function Shop(){

    const productsToSale = useGetProductsToSale()
    const {cart, addProduct} = useCart()

    return(
        <main class="contenedor">
            <div id="productos" class="grid-tienda">
                <Seeker/>
                <div class="container-productos">
                    <div class="grid-productos">
                        {productsToSale.isFetching ? <h1>cargando</h1> : productsToSale.data.map(product => <Product key={product.id} product={product} addProduct={addProduct}/>)}
                    </div>
                </div>               
            
            </div>
            
        </main>
    )
}

export default Shop