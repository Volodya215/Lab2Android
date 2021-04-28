package Goldberg

import kotlin.random.Random

data class DataForOperation<T, Q>(val firstAddition: T, val secondAddition: Q)

enum class Operation (val operation: Int) {
    ADD(0),
    SUBTRACTION(1)
}

interface AddData {
    fun add(one: Int, second: Int): Int
}

object AddInteger: AddData {
    override fun add(one: Int, second: Int): Int {
        return one + second
    }
}

abstract class GoldbergAbstract: AddData by AddInteger {
    abstract fun doOperation()
}

open class Goldberg<T, Q> (private var typeOfOperation: Operation = Operation.ADD, private var data: DataForOperation<T, Q>): GoldbergAbstract() {

    private lateinit var action: Operation
    private var valueOne: Int = 0
    private var valueTwo: Int = 0

    // Property
    protected var someKoef : DataForOperation<T, Q>
        get() = data
        private set(value) {data = value}

    init {
        if(someKoef!= null) {
            valueOne = someKoef.firstAddition.toString().toInt()
            valueTwo = someKoef.secondAddition.toString().toInt()
        }
    }

/*    constructor(someComment: String): this() {
        println(someComment)
    }*/

    override fun doOperation() {
        initializeAction()
        if (action == Operation.ADD) {
            println("Result sum = " + add(valueOne, valueTwo))
        } else if (action == Operation.SUBTRACTION) {
            println("Result difference = " + valueOne.subtraction(valueTwo))
        } else {
            println("Unknown operation!!!")
        }
    }

    companion object fun initializeAction(operation: Operation = typeOfOperation) {
        action = if (operation == Operation.ADD) {
            Operation.ADD
        } else {
            Operation.SUBTRACTION
        }
    }
}

fun Int.subtraction(y: Int): Int{
    return this - y
}

