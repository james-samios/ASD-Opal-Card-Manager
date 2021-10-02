package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import org.bson.Document;


@Getter
public class WeeklyTripReward extends Document {
    private final double rewardPercentage;
    private final String rewardName;
    private final boolean rewardClaimed;

    public WeeklyTripReward(Document document) {
        this.rewardPercentage = document.getDouble("reward_percentage");
        this.rewardName = document.getString("reward_name");
        this.rewardClaimed = document.getBoolean("reward_claimed");
    }

    @Override
    public String toString() {
        return rewardPercentage + " " + rewardName + " " + rewardClaimed;
    }

}
