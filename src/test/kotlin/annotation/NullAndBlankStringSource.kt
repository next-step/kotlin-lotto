package annotation

import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@NullSource
@ValueSource(strings = ["", " "])
annotation class NullAndBlankStringSource
