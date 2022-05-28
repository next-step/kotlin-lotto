package camp.nextstep.lotto

import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.converter.ArgumentConverter

class IntArrayConverter : ArgumentConverter {

    override fun convert(source: Any?, context: ParameterContext?): IntArray {
        require(source is String)
        return source.split(",").map { it.trim().toInt() }.toIntArray()
    }
}
