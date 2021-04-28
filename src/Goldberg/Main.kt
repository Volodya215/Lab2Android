package Goldberg
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    println("Enter your first integer number: ")
    val firstNum = readLine()
    println("Enter your first integer number: ")
    val secondNum = readLine()

    val list = mutableListOf(firstNum, secondNum)
    if (ValidateData.checkData(list) == MyBool.FALSE) {
        println("Incorrect data!!! The system stops working...")
        return
    }

    val data = convertData(firstNum.toString(), secondNum.toString())

    val goldberg = Goldberg(Operation.ADD, data)
    goldberg.doOperation()

    val goldberg2 = Goldberg(Operation.SUBTRACTION, data)
    goldberg2.doOperation()

}

fun convertData(num1: String, num2: String): DataForOperation<Int, Int> {
    var dayNum = (1..7).random()
    val day = LocalDate.now().getDayOfWeek().getValue()

    dayNum = if(dayNum == day) {5} else {day}

    return when (dayNum) {
        in 1..2 ->  DataForOperation(convertToIntFromDouble(num1.toDouble()), num2.toInt())
        in 3..5 ->  DataForOperation(convertToIntFromCharArray(num1.toBigDecimal()), convertToIntFromCharArray(num2.toBigDecimal()))
        in 6..7 ->  DataForOperation(num1.toInt(), num2.toInt())
        else -> {
            println("Something has happened to your space-time continuum!!!")
            println("I don't want to work on this strange day!!!")
            DataForOperation(0, 0)
        }
    }
}

fun convertToIntFromDouble(value: Double): Int {
    return value.toInt()
}

fun convertToIntFromCharArray(value: BigDecimal): Int {
    return value.toInt()
}