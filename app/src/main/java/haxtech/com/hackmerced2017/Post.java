package haxtech.com.hackmerced2017;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Post {

    public String uid;
    public String userID;
    public String body;
    public ArrayList<String> commentIDs;

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String userID, String body) {
        this.uid = uid;
        this.userID = userID;
        this.body = body;
        this.commentIDs = new ArrayList<>();
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("userID", userID);
        result.put("body", body);
        result.put("comments", commentIDs);
        return result;
    }

    public void newComment(String commentID){
        commentIDs.add(commentID);
    }

}