package creational

/**
 * Factory Class
 * - interface for creating class instances
 * - allow subclasses to decide which class to create
 */
interface Button {
    fun render()
    fun <T> onClick(action: () -> T) = action()
}

class HTMLButton : Button {
    override fun render() = println("<creational.Button></creational.Button>")
}

class X11Button : Button {
    override fun render() = println("""❓🔽🔼🗙""")
}

abstract class Dialog {
    abstract fun button(): Button
    fun <T> render(action: () -> T) {
        button().apply {
            render()
            onClick(action)
        }
    }
}

class X11Dialog : Dialog() {
    override fun button() = HTMLButton()
}

class WebDialog : Dialog() {
    override fun button() = X11Button()
}

class App(env: String) {
    val dialog = when (env) {
        "Linux" -> X11Dialog()
        "Web" -> WebDialog()
        else -> throw Exception("Unknown Environment: $env")
    }
}

fun main() = listOf("Linux", "Web").forEach { env ->
    App(env).dialog.render { println("Hello, World!") }
}
