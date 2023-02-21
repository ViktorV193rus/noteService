object NotesService {

    internal var notesList: MutableList<Note> = mutableListOf()
    internal var commentsList: MutableList<NoteComment> = mutableListOf()

    fun clear() {
        notesList.clear()
        commentsList.clear()
    }
}

fun main() {

    val comment1 = NoteComment(0, 0, 1, null, "message1")
    val note = Note(
        id = 0,
        title = "title1",
        text = "text1",
        date = 1,
        privacy = 0,
        comments = comment1
    )

    val noteCase = CaseNote(note, NotesService.notesList)
    println(NotesService.notesList)

    noteCase.add(note)
    println(NotesService.notesList)

    val commentCase = CaseNoteComment(comment1, NotesService.commentsList)
    println(NotesService.commentsList)

    commentCase.add(comment1)
    println(NotesService.commentsList)

    commentCase.delete(1)
    println(NotesService.commentsList)
    println(NotesService.notesList)
}