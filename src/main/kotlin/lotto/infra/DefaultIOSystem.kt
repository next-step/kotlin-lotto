package lotto.infra

import lotto.infra.port.IOSystem

class DefaultIOSystem : IOSystem {

    override fun read(): String = readLine() ?: ""

    override fun write(content: String) = print(content)
}
