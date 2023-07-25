
function Seeker(){

    return (
        
        <div class="div-opciones-productos">
            <p>Buscar por</p>
            <div class="filtro-producto">
                <label for="">Nombre</label>
                <input type="text" name="nombre" id="" />
            </div>

            <p>Categoria</p>
            <div class="filtros-producto">

                <label for="">Cualquiera</label>
                <input  type="radio" name="categoria" id="" value="0" />
                
                <label for="">Carne</label>
                <input type="radio" name="categoria" id="" value="1" />    
            </div>

            <input class="btn btn-verde" type="submit" value="Buscar" />
        </div>
        
    )
}

export default Seeker