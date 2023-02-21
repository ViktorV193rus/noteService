data class Note(
    var id: Int = 0,
    var title: String? = "title",
    var text: String? = "text",
    val date: Int = 0,
    var privacy: Int = 0,
    var comments: NoteComment?,
    var isDeleted: Boolean = false
)

data class NoteComment(
    var id: Int = 0,
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val replyTo: String? = null,
    var message: String? = "messaqe",
    var isDeleted: Boolean = false
)