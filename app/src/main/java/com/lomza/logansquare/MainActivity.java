package com.lomza.logansquare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bluelinelabs.logansquare.LoganSquare;
import com.lomza.logansquare.model.DateConverter;
import com.lomza.logansquare.model.Status;
import com.lomza.logansquare.model.Thumbnail;
import com.lomza.logansquare.model.YouTubeVideo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView;
    private Button parseButton;
    private Button serializeButton;

    private List<YouTubeVideo> videoList = new ArrayList<>();

    private final static String TAG = MainActivity.class.getSimpleName();
    private final static String JSON_TO_PARSE = "[{\n" +
            "        \"id\":\"abcd1234\",\n" +
            "        \"uploaded\":\"2016-01-01T10:04:00.234-0600\",\n" +
            "        \"updated\":\"2016-01-02T12:00:00.412-0600\",\n" +
            "        \"category\":\"Tutorials\",\n" +
            "        \"title\":\"How to use LoganSquare?\",\n" +
            "        \"description\":\"It is quite easy! Just watch the video.\",\n" +
            "        \"tags\":[\n" +
            "        \"Tutorial\",\"programming\",\"Android\"\n" +
            "        ],\n" +
            "        \"thumbnail\":{\n" +
            "        \"default\":\"https://maps.zomato.com/osm/13/2100/3042.png\",\n" +
            "        \"hqDefault\":\"https://www.google.com/maps/d/u/0/thumbnail?mid=z0WkcfeJUFkQ.k6o6yNM5WU64&hl=en\"\n" +
            "        },\n" +
            "        \"content\":{\n" +
            "        \"1\":\"http://a4.mzstatic.com/us/r30/Purple3/v4/d6/e4/12/d6e41207-d0ee-96c5-6f9d-e789c6e4caf7/icon128-2x.png\",\n" +
            "        \"2\":\"https://www.youtube.com/yt/brand/media/image/YouTube-icon-dark.png\",\n" +
            "        \"4\":\"http://icons.iconarchive.com/icons/danleech/simple/512/youtube-icon.png\"\n" +
            "        },\n" +
            "        \"duration\":4060,\n" +
            "        \"rating\":4.23,\n" +
            "        \"viewCount\":10999,\n" +
            "        \"commentCount\":24,\n" +
            "        \"status\": \"REMOVED\"" +
            "},\n" +
            "{\n" +
            "        \"id\":\"dcab4321\",\n" +
            "        \"uploaded\":\"2016-04-12T14:07:00.435-0600\",\n" +
            "        \"updated\":\"2016-04-23T13:10:00.251-0600\",\n" +
            "        \"category\":\"Tutorials\",\n" +
            "        \"title\":\"How to use LoganSquare (part 2)?\",\n" +
            "        \"description\":\"Watch the second, more matured video.\",\n" +
            "        \"tags\":[\n" +
            "        \"Tutorial\",\"programming\",\"Android\"\n" +
            "        ],\n" +
            "        \"thumbnail\":{\n" +
            "        \"default\":\"https://maps.zomato.com/osm/13/2100/3042.png\",\n" +
            "        \"hqDefault\":\"https://www.google.com/maps/d/u/0/thumbnail?mid=z0WkcfeJUFkQ.k6o6yNM5WU64&hl=en\"\n" +
            "        },\n" +
            "        \"content\":{\n" +
            "        \"1\":\"https://www.youtube.com/yt/brand/media/image/YouTube-icon-dark.png\",\n" +
            "        \"5\":\"https://www.youtube.com/yt/brand/media/image/YouTube-logo-full_color.png\",\n" +
            "        \"6\":\"http://a4.mzstatic.com/us/r30/Purple3/v4/d6/e4/12/d6e41207-d0ee-96c5-6f9d-e789c6e4caf7/icon128-2x.png\"\n" +
            "        },\n" +
            "        \"duration\":6022,\n" +
            "        \"rating\":4.66,\n" +
            "        \"viewCount\":2087,\n" +
            "        \"commentCount\":10,\n" +
            "        \"status\": \"ADDED\"" +
            "}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initLoganConfig();
        addSampleVideos();
    }

    private void init() {
        resultTextView = (TextView) findViewById(R.id.tv_result);
        parseButton = (Button) findViewById(R.id.b_parse);
        serializeButton = (Button) findViewById(R.id.b_serialize);

        parseButton.setOnClickListener(this);
        serializeButton.setOnClickListener(this);
    }

    private void initLoganConfig() {
        LoganSquare.registerTypeConverter(Date.class, new DateConverter());
    }

    private void addSampleVideos() {
        final List<String> tags = new ArrayList<>();
        tags.add("Tutorial");
        tags.add("programming");
        tags.add("Android");

        final Thumbnail thumbnail = new Thumbnail();
        thumbnail.setDefaultUrl("http://www.elite-presentations.com/new/wp-content/uploads/2015/02/production-icon.png");
        thumbnail.setHqDefaultUrl("http://www.iconsdb.com/icons/preview/red/video-play-xxl.png");

        final HashMap<String, String> content = new HashMap<>(2);
        content.put("1", "IDE integration");
        content.put("2", "Library usage");

        Calendar oldTime = Calendar.getInstance();
        oldTime.set(1991, 4, 6);
        Calendar nowTime = Calendar.getInstance();
        final Date uploadDate = oldTime.getTime();
        final Date updateDate = nowTime.getTime();

        videoList.add(new YouTubeVideo("abc123", uploadDate, updateDate,
                "Tutorials", "How to use LoganSquare?", "It is quite easy! Just watch the video.",
                tags, thumbnail, content, 256, 4.50, 10999, 104, Status.REMOVED, false));
        videoList.add(new YouTubeVideo("aySd934", uploadDate, updateDate,
                "Tutorials", "How to make a beautiful Material Design app?", "Follow us!",
                tags, thumbnail, content, 512, 4.23, 4255, 23, Status.ADDED, true));
        videoList.add(new YouTubeVideo("35sGNA", uploadDate, updateDate,
                "Tutorials", "What\'s new in Android world?", "New versions appear very fast!",
                tags, thumbnail, content, 23, 3.0, 998, 98, Status.BLOCKED, false));
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.b_parse) {
            handleParsing();
        } else if (id == R.id.b_serialize) {
            handleSerialization();
        }
    }

    public void handleParsing() {
        try {
            final List<YouTubeVideo> youTubeVideos = LoganSquare.parseList(JSON_TO_PARSE, YouTubeVideo.class);
            String parsedList = "";
            for (YouTubeVideo video : youTubeVideos) {
                Log.d(TAG, "[Object.Parsed]:" + video.toString());
                parsedList += video.toString();
            }
            resultTextView.setText(parsedList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleSerialization() {
        try {
            String jsonString = LoganSquare.serialize(videoList).replace(",", ",\n").replace("{", "{\n").replace("}", "}\n");
            Log.d(TAG, "[JSON.Serialized]:" + jsonString);
            resultTextView.setText(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
