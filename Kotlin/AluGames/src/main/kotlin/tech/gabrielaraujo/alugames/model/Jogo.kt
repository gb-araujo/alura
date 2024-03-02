package tech.gabrielaraujo.alugames.model

data class Jogo(val titulo: String,val capa: String) {
    var descricao:String? = null
    override fun toString(): String {
        return "Jogo: " +
                "\ntitulo='$titulo', " +
                "\ncapa='$capa', " +
                "\ndescricao='$descricao'"
    }
}