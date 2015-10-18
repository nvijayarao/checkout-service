package service

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CheckoutServiceSpec extends FlatSpec with Matchers{

    "Cart price" should "have zero price " in {
      val shoppingCart = List()  
      assertResult(CheckoutService.getCartPrice(shoppingCart))(0.00)
     }
     
     it should "have 60 pence price" in {
       val shoppingCart = List("Apple")  
      assertResult(CheckoutService.getCartPrice(shoppingCart))(0.60)
     }
  
     it should "have 85 pence price" in {
      val shoppingCart = List("Apple", "Orange")  
      assertResult(CheckoutService.getCartPrice(shoppingCart))(0.85)
     }
     
     it should "have 2.05 pounds price" in {
      val shoppingCart = List("Apple", "Apple", "Orange","Apple") 
      assertResult(CheckoutService.getCartPrice(shoppingCart))(2.05)
     }
     
     "Cart price with discount" should "have 60 pence price" in {
      val shoppingCart = List("Apple", "Apple")  
      assertResult(CheckoutService.getCartPriceWithDiscount(shoppingCart))(0.60)
     }
  
     it should "have 85 pence price" in {
      val shoppingCart = List("Apple", "Apple", "Orange")  
      assertResult(CheckoutService.getCartPriceWithDiscount(shoppingCart))(0.85)
     }
     
     it should "have 1.7 pounds price" in {
      val shoppingCart = List("Apple", "Apple", "Orange","Orange","Orange","Apple") 
      assertResult(CheckoutService.getCartPriceWithDiscount(shoppingCart))(1.70)
     }
  
}