enum class RequestType(val description: String) {
    DEFEND_CASTLE("Defend castle"),
    TORTURE_PRISONER("Torture prisoner"),
    COLLECT_TAX("Collect tax"),
    CLEAN_TOILET("Clean toilets")
}

// Créez les classes nécessaires à la résolution du programme
// Vous pouvez ajouter des attributs et des méthodes aux classes
// Vous pouvez ajouter des classes si vous le souhaitez
// Vous aurez besoin au minimum des classes suivantes :
// - Request
// - RequestHandler
// - OrcCommander : RequestHandler
// - OrcOfficer : RequestHandler
// - OrcSoldier : RequestHandler

data class Request(val requestType: RequestType) {
    override fun toString(): String {
        return requestType.description
    }
}

abstract class RequestHandler(private val next: RequestHandler?) {
    open fun handleRequest(req: Request) {
        next?.handleRequest(req) ?: println("Request $req not handled")
    }

    protected fun printHandling(req: Request) {
        println("$this handling request $req")
    }

    abstract override fun toString(): String
}

class OrcCommander(handler: RequestHandler?) : RequestHandler(handler) {
    override fun handleRequest(req: Request) {
        if (req.requestType == RequestType.DEFEND_CASTLE) {
            printHandling(req)
        } else {
            super.handleRequest(req)
        }
    }

    override fun toString(): String {
        return "Orc commander"
    }
}

class OrcOfficer(handler: RequestHandler?) : RequestHandler(handler) {
    override fun handleRequest(req: Request) {
        if (req.requestType == RequestType.TORTURE_PRISONER) {
            printHandling(req)
        } else {
            super.handleRequest(req)
        }
    }

    override fun toString(): String {
        return "Orc officer"
    }
}

class OrcSoldier(handler: RequestHandler?) : RequestHandler(handler) {
    override fun handleRequest(req: Request) {
        if (req.requestType == RequestType.COLLECT_TAX) {
            printHandling(req)
        } else {
            super.handleRequest(req)
        }
    }

    override fun toString(): String {
        return "Orc soldier"
    }
}

class OrcKing {
    private var chain: RequestHandler = OrcCommander(OrcOfficer(OrcSoldier(null)))

    fun makeRequest(req: Request?) {
        chain.handleRequest(req!!)
    }
}

fun main(args: Array<String>) {
    val king = OrcKing()
    king.makeRequest(Request(RequestType.DEFEND_CASTLE))
    king.makeRequest(Request(RequestType.TORTURE_PRISONER))
    king.makeRequest(Request(RequestType.COLLECT_TAX))
    king.makeRequest(Request(RequestType.CLEAN_TOILET))
    king.makeRequest(Request(RequestType.DEFEND_CASTLE))
    king.makeRequest(Request(RequestType.TORTURE_PRISONER))
    king.makeRequest(Request(RequestType.COLLECT_TAX))
}