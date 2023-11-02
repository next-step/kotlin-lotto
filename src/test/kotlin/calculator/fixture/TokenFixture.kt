package calculator.fixture

import calculator.model.Token

object TokenFixture {
    val TOKEN = ArrayDeque((0..100).map { Token(it) })
}
