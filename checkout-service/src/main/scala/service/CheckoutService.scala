package service

import domain.Item
import domain.Apple
import domain.Orange

object CheckoutService {
  
  def getCartPrice(list: List[String]): Double = {
    val cartItems = getCartItems(list)
    cartItems.map { x => x.price }.sum
  }    
  
  def getCartItems(list: List[String]): List[Item] = {
    list.map { x => Item.apply(x) }
  }
  
  def getCartPriceWithDiscount(list: List[String]): Double = {
    var totalPrice: Double = 0
    if(list.contains("Apple")){
      val appleCount = list.groupBy(identity).mapValues(_.size)("Apple")
      totalPrice  = totalPrice + getAppleDiscountPrice(appleCount, Item.apply("Apple"))
    }
    if(list.contains("Orange")){
      val orangeCount = list.groupBy(identity).mapValues(_.size)("Orange")
      totalPrice = totalPrice + getOrangeDiscountPrice(orangeCount, Item.apply("Orange"))
    }
    totalPrice
  } 
  
  def getAppleDiscountPrice(appleCount : Int, apple: Item): Double = {       
    if(appleCount % 2 == 0) apple.price * appleCount/2
    else (apple.price * (appleCount-1)/2) + apple.price
  }
  
  def getOrangeDiscountPrice(orangeCount : Int, orange : Item): Double = {
    if(orangeCount % 3 == 0) orange.price * ((orangeCount/3)*2)
    else (orange.price * ((orangeCount-(orangeCount % 3))/3)*2) + ((orangeCount % 3) * orange.price)
  }
  
}