
const CartHeader = (props) =>{

    const {totalQuantity, totalPrice, products} = props
    
    return(
        products.length > 0 ? (
            <>
                <div class="carrito-detalles">
                    <p>Productos: {totalQuantity}<span class="bold"></span></p> 
                    <p>Total: ${totalPrice.toFixed(2)}<span class="bold"></span></p>   
                </div>
                <a href="/comprar" className="btn btn-rojo finalizar-compra">Finalizar Compra</a>  
            </> 
        ): null
    )
}

export default CartHeader