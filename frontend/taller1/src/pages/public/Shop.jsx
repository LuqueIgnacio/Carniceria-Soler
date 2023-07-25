import "../../css/Tienda.css"
import React from "react"
import Seeker from "../../components/shop/Seeker"
import Product from "../../components/shop/Product"
import {useGetProductsToSale} from "../../hooks/ProductsHooks"

function Shop(){

    const products = useGetProductsToSale()
    
    return(
        <main class="contenedor">
            <div id="productos" class="grid-tienda">
                <Seeker/>
                <div class="container-productos">
                    <div class="grid-productos">
                        {products.isFetching ? <h1>cargando</h1> : products.data.map(product => <Product product={product}/>)}
                    </div>
                </div>               
            
            </div>
            
        </main>
    )
}

export default Shop