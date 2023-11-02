package calculator.fixture

import calculator.model.Token

object TokenFixture {
    val TOKEN = ArrayDeque((1..100).map { Token(it) })
}
