import "../../css/ProductoTienda.css"

function Product(props){
    const {product} = props

    return(
        <div class="oferta">
            <div class="card d-inline-block" >
                <img loading="lazy" src={`assets/products/${product.image}`} class="card-img-top" alt="..."/>
                <div class="card-body">
                    <h5 class="card-title">{product.name}</h5>
                    <p class="oferta-precio">${product.price}</p>
                    <button type="button" class="btn btn-rojo btn-producto">Agregar al carrito</button>
                </div>
            </div>
        </div>
    )
}

export default Product