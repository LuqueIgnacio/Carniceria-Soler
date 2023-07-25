import { createContext } from "react";
import useLocalStorage from "../hooks/useLocalStorage";

export const CartContext = createContext([])

export const CartContextProvider = (props) =>{
    const [cart, setCart] = useLocalStorage("cart", [])
    
    const addProduct = (product) =>{
        const index = cart.findIndex(p => p.id == product.id)

        if(index != -1){
            const newCart = cart.slice()
            newCart[index].quantity++
            setCart(newCart)
        }else{
            delete product.brand
            delete product.category
            setCart([...cart, {...product, quantity: 1}])
        }
    }

    const deleteProduct = (id) =>{
        setCart(cart.filter(p => p.id != id))
    }

    const decreaseProduct = (id) =>{
        const index = cart.findIndex(p => p.id == id)
        if(index == -1){
            return
        }
    
        if(cart[index].quantity == 1){
            deleteProduct(id)
        }else{
            const newCart = cart.slice()
            newCart[index].quantity--
            setCart(newCart)
        }

        
    }

    let totalPrice = 0
    let totalQuantity = 0
    cart.forEach(p =>{
        totalPrice += p.price * p.quantity
        totalQuantity += p.quantity
    }) 


    return(
        <CartContext.Provider value={{cart, addProduct, decreaseProduct, deleteProduct, totalPrice, totalQuantity}}>
            {props.children}
        </CartContext.Provider>
    )
}