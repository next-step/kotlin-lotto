package lotto

data class Blog(val name: String = "")

class Blogs(
    val blogs: List<Blogs> = emptyList()
) {

    fun of(blogs: List<Blogs>) = Blogs(blogs)
}

fun hello() {

    val blogs: List<Blogs> = Blogs()
        .blogs.map {
            it
        }
}
