package lotto.domain.input

import lotto.util.Reader

class ConsoleInput : ClientInput {
    override fun read(): String {
        return Reader.read()
    }
}
