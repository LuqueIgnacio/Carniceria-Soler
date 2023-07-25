import {useQuery} from "react-query"
import {getProductsToSale} from "../services/ProductsService"

export const useGetProductsToSale = () => {
    return useQuery("products", getProductsToSale)
}