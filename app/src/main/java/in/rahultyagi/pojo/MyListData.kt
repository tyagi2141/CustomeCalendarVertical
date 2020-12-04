package `in`.rahultyagi.pojo

/**
 * Created by Rahul on 03/12/20.
 */
class MyListData(description: String, imgId: String) {
    private var description: String
    private var imgId: String
    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getImgId(): String {
        return imgId
    }

    fun setImgId(imgId: String) {
        this.imgId = imgId
    }

    init {
        this.description = description
        this.imgId = imgId
    }
}