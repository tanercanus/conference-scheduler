package conference;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.conference.bean.SubmitBean;
import com.conference.model.Conference;
import com.conference.model.Track;
import com.conference.util.MainUtil;

public class MainTest {

	private String postInput = "Architecting Your Codebase__60," + "Overdoing it in Python__45,"
			+ "Flavors of Concurrency in Java__30," + "Ruby Errors from Mismatched Gem Versions__45,"
			+ "JUnit 5 - Shaping the Future of Testing on the JVM__45," + "Cloud Native Java lightning__0,"
			+ "Communicating Over Distance__60," + "AWS Technical Essentials__45," + "Continuous Delivery__30,"
			+ "Monitoring Reactive Applications__30," + "Pair Programming vs Noise__45," + "Rails Magic__60,"
			+ "Microservices 'Just Right'__60," + "Clojure Ate Scala (on my project)__45," + "Perfect Scalability__30,"
			+ "Apache Spark__30," + "Async Testing on JVM__60," + "A World Without HackerNews__30,"
			+ "User Interface CSS in Apps__30,";

	@Test
	public void convertBeanAndCreateConference() {
		SubmitBean submitBean = new SubmitBean();
		submitBean.setPostInput(postInput);

		List<ArrayList<Conference>> allConferences = new ArrayList<ArrayList<Conference>>();
		ArrayList<Conference> conferences = new ArrayList<>();

		conferences.add(new Conference("Architecting Your Codebase", 60, false));
		conferences.add(new Conference("Overdoing it in Python", 45, false));
		conferences.add(new Conference("Flavors of Concurrency in Java", 30, false));
		conferences.add(new Conference("Ruby Errors from Mismatched Gem Versions", 45, false));
		conferences.add(new Conference("JUnit 5 - Shaping the Future of Testing on the JVM", 45, false));
		conferences.add(new Conference("Communicating Over Distance", 60, false));
		conferences.add(new Conference("AWS Technical Essentials", 45, false));
		conferences.add(new Conference("Continuous Delivery", 30, false));
		conferences.add(new Conference("Monitoring Reactive Applications", 30, false));
		conferences.add(new Conference("Pair Programming vs Noise", 45, false));
		conferences.add(new Conference("Rails Magic", 60, false));
		conferences.add(new Conference("Microservices 'Just Right'", 60, false));
		conferences.add(new Conference("Clojure Ate Scala (on my project)", 45, false));
		conferences.add(new Conference("Perfect Scalability", 30, false));
		conferences.add(new Conference("Apache Spark", 30, false));
		conferences.add(new Conference("Async Testing on JVM", 60, false));
		conferences.add(new Conference("A World Without HackerNews", 30, false));
		conferences.add(new Conference("User Interface CSS in Apps", 30, false));

		ArrayList<Conference> lightningConferences = new ArrayList<>();
		lightningConferences.add(new Conference("Cloud Native Java lightning", 0, false));

		allConferences.add(conferences);
		allConferences.add(lightningConferences);

		List<ArrayList<Conference>> allConferencesMain = MainUtil.convertSubmitBeanToList(submitBean.getPostInput());

		for (int i = 0; i < conferences.size(); i++) {
			assertEquals(conferences.get(i).getName(), allConferencesMain.get(0).get(i).getName());
			assertEquals(conferences.get(i).getTime(), allConferencesMain.get(0).get(i).getTime());
		}

		for (int i = 0; i < lightningConferences.size(); i++) {
			assertEquals(lightningConferences.get(i).getName(), allConferencesMain.get(1).get(i).getName());
			assertEquals(lightningConferences.get(i).getTime(), allConferencesMain.get(1).get(i).getTime());
		}

	}

	@Test
	public void createTracks() {

		List<Track> tracks = new ArrayList<>();
		Track track1 = new Track();
		tracks.add(track1);
		track1.getConferenceList().add("09:00 AM Architecting Your Codebase 60min");
		track1.getConferenceList().add("10:00 AM Overdoing it in Python 45min");
		track1.getConferenceList().add("10:45 AM Flavors of Concurrency in Java 30min");
		track1.getConferenceList().add("11:15 AM Ruby Errors from Mismatched Gem Versions 45min");
		track1.getConferenceList().add("12:00 PM Lunch");
		track1.getConferenceList().add("01:00 PM JUnit 5 - Shaping the Future of Testing on the JVM 45min");
		track1.getConferenceList().add("01:45 PM Communicating Over Distance 60min");
		track1.getConferenceList().add("02:45 PM AWS Technical Essentials 45min");
		track1.getConferenceList().add("03:30 PM Continuous Delivery 30min");
		track1.getConferenceList().add("04:00 PM Monitoring Reactive Applications 30min");
		track1.getConferenceList().add("04:30 PM Perfect Scalability 30min");
		track1.getConferenceList().add("05:00 PM Networking Event");

		Track track2 = new Track();
		tracks.add(track2);
		track2.getConferenceList().add("09:00 AM Pair Programming vs Noise 45min");
		track2.getConferenceList().add("09:45 AM Rails Magic 60min");
		track2.getConferenceList().add("10:45 AM Microservices 'Just Right' 60min");
		track2.getConferenceList().add("11:45 AM Cloud Native Java lightning");
		track2.getConferenceList().add("12:00 PM Lunch");
		track2.getConferenceList().add("01:00 PM Clojure Ate Scala (on my project) 45min");
		track2.getConferenceList().add("01:45 PM Apache Spark 30min");
		track2.getConferenceList().add("02:15 PM Async Testing on JVM 60min");
		track2.getConferenceList().add("03:15 PM A World Without HackerNews 30min");
		track2.getConferenceList().add("03:45 PM User Interface CSS in Apps 30min");
		track2.getConferenceList().add("04:15 PM Networking Event");

		SubmitBean submitBean = new SubmitBean();
		submitBean.setPostInput(postInput);
		List<ArrayList<Conference>> allConferences = MainUtil.convertSubmitBeanToList(submitBean.getPostInput());
		List<Track> tracksProgram = MainUtil.scheduleConferences(allConferences);

		for (int i = 0; i < tracks.size(); i++) {
			Track trackTest = tracks.get(i);
			Track trackProgram = tracksProgram.get(i);
			for (int j = 0; j < trackTest.getConferenceList().size(); j++) {
				assertEquals(trackTest.getConferenceList().get(j).toString(),
						trackProgram.getConferenceList().get(j).toString());
			}
		}

	}

}
