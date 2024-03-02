package tech.gabrielaraujo.alugames.model

data class InfoApiFreeToGame(val title: String, val thumbnail:String) {
    override fun toString(): String {
        return "Titulo: " + title + "Thumb" + thumbnail
    }
}
