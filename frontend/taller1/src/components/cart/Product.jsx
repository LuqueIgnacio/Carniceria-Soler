import React from "react"

const Product = (props) =>{
    const {product, deleteProduct, addProduct, decreaseProduct} = props

    const handleDeleteProduct = () =>{
        deleteProduct(product.id)
    }

    const handleAddProduct = () =>{
        addProduct(product)
    }

    const handleDecreaseProduct = () =>{
        decreaseProduct(product.id)
    }

    return(
        <>
        <div class="producto-carrito">
            <div class="producto-carrito-datos">
                <div class="producto-carrito-img">
                    <img src={"assets/products/" + product.image} alt=""/>
                </div>
                <p>{product.name}</p>
                <svg onClick={handleDeleteProduct} class="btn-carrito producto-carrito-basura" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                    <path  d="M160 400C160 408.8 152.8 416 144 416C135.2 416 128 408.8 128 400V192C128 183.2 135.2 176 144 176C152.8 176 160 183.2 160 192V400zM240 400C240 408.8 232.8 416 224 416C215.2 416 208 408.8 208 400V192C208 183.2 215.2 176 224 176C232.8 176 240 183.2 240 192V400zM320 400C320 408.8 312.8 416 304 416C295.2 416 288 408.8 288 400V192C288 183.2 295.2 176 304 176C312.8 176 320 183.2 320 192V400zM317.5 24.94L354.2 80H424C437.3 80 448 90.75 448 104C448 117.3 437.3 128 424 128H416V432C416 476.2 380.2 512 336 512H112C67.82 512 32 476.2 32 432V128H24C10.75 128 0 117.3 0 104C0 90.75 10.75 80 24 80H93.82L130.5 24.94C140.9 9.357 158.4 0 177.1 0H270.9C289.6 0 307.1 9.358 317.5 24.94H317.5zM151.5 80H296.5L277.5 51.56C276 49.34 273.5 48 270.9 48H177.1C174.5 48 171.1 49.34 170.5 51.56L151.5 80zM80 432C80 449.7 94.33 464 112 464H336C353.7 464 368 449.7 368 432V128H80V432z"/>
                </svg>   
            </div>
            <div class="producto-carrito-opciones">
                <p class="bold" >$<span class="producto-carrito-precio bold" >{product.price}</span></p>
                
                <svg onClick={handleDecreaseProduct} className="btn-carrito producto-carrito-add min h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth="2">
                    <path  class="min" strokeLinecap="round" strokeLinejoin="round" d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>
                <p class="producto-carrito-cantidad">{product.quantity}</p>
                <svg onClick={handleAddProduct} className="btn-carrito producto-carrito-add add h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth="2">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>

            </div>
        </div>
        </>
    ) 
}

export default Product