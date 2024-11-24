package calculator.exception

class NegativeNumberException(negatives: List<Int>) :
    RuntimeException("Negatives not allowed: $negatives")
