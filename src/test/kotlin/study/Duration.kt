package study

@JvmInline
value class Duration(
    val millis: Long,
) {
    constructor(haha: String, hihi: String) : this(haha.toLong())

    companion object {
        fun millis(millis: Long) = Duration(millis)

        fun millis(millis: String) = Duration(millis.toLong())

        fun seconds(seconds: Long) = Duration(seconds * 1000)
    }
}
