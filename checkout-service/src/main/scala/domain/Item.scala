package domain

/**
 * @author nvijayar
 */

trait Item {
  val name: String
  val price : Double
}

case class Apple (name:String, price : Double) extends Item

case class Orange (name:String, price : Double) extends Item

object Item {
  
  def apply(name : String) : Item = {
    name match {
      case "Apple" => Apple("Apple", 0.60)
      case "Orange" => Orange("Orange", 0.25)
      case _ => null
    }
  }
}

