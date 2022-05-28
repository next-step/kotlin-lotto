package lotto.auto.infra

import lotto.auto.infra.port.IOSystem

class DefaultIOSystem : IOSystem {

    override fun read(): String = readLine() ?: ""

    override fun write(content: String) = print(content)
}
