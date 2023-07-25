import axios from "axios"

export const getProductsToSale = async () =>{
    const response = await axios.get("http://localhost:8080/productsToSale")
    return response.data
}