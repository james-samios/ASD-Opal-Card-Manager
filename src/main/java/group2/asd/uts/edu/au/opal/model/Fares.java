package group2.asd.uts.edu.au.opal.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.UUID;

@Getter @Setter
public class Fares extends Document {
    private ObjectId objectId;
    private UUID fareId;
    private double daily_weekly_min;
    private double daily_weekly_max;
    private double daily_weekly_weekends;
    //metro and train
    private double metro_train_single_0_10;
    private double metro_train_single_10_20;
    private double metro_train_single_20_35;
    private double metro_train_single_35_65;
    private double metro_train_single_65;

    private double metro_train_off_peak_0_10;
    private double metro_train_off_peak_10_20;
    private double metro_train_off_peak_20_35;
    private double metro_train_off_peak_35_65;
    private double metro_train_off_peak_65;

    private double metro_train_fare_0_10;
    private double metro_train_fare_10_20;
    private double metro_train_fare_20_35;
    private double metro_train_fare_35_65;
    private double metro_train_fare_65;

    //Bus
    private double Bus_single_0_3;
    private double Bus_single_3_8;
    private double Bus_single_8;


    private double Bus_off_peak_0_3;
    private double Bus_off_peak_3_8;
    private double Bus_off_peak_8;


    private double Bus_fare_0_3;
    private double Bus_fare_3_8;
    private double Bus_fare_8;


    //Ferry
    private double Ferry_single_0_9;
    private double Ferry_single_9;
    private double Ferry_single_NS_0_3;


    private double Ferry_off_peak_0_9;
    private double Ferry_off_peak_9;
    private double Ferry_off_peak_NS_0_3;


    private double Ferry_fare_0_9;
    private double Ferry_fare_9;
    private double Ferry_fare_NS_0_3;

    //Light rail fares
    private double Light_rail_single_0_3;
    private double Light_rail_single_3_8;
    private double Light_rail_single_8;


    private double Light_rail_off_peak_0_3;
    private double Light_rail_off_peak_3_8;
    private double Light_rail_off_peak_8;


    private double Light_rail_fare_0_3;
    private double Light_rail_fare_3_8;
    private double Light_rail_fare_8;


    /*public void method_name(parameter1, parameter2) {
    }*/


    public Fares(
            UUID fareId,
            final double daily_weekly_min,
            final double daily_weekly_max,
            final double daily_weekly_weekends,
            final double metro_train_single_0_10,
            final double metro_train_single_10_20,
            final double metro_train_single_20_35,
            final double metro_train_single_35_65,
            final double metro_train_single_65,
            final double metro_train_off_peak_0_10,
            final double metro_train_off_peak_10_20,
            final double metro_train_off_peak_20_35,
            final double metro_train_off_peak_35_65,
            final double metro_train_off_peak_65,

            final double metro_train_fare_0_10,
            final double metro_train_fare_10_20,
            final double metro_train_fare_20_35,
            final double metro_train_fare_35_65,
            final double metro_train_fare_65,

            //Bus
            final double Bus_single_0_3,
            final double Bus_single_3_8,
            final double Bus_single_8,


            final double Bus_off_peak_0_3,
            final double Bus_off_peak_3_8,
            final double Bus_off_peak_8,


            final double Bus_fare_0_3,
            final double Bus_fare_3_8,
            final double Bus_fare_8,


            //Ferry
            final double Ferry_single_0_9,
            final double Ferry_single_9,
            final double Ferry_single_NS_0_3,


            final double Ferry_off_peak_0_9,
            final double Ferry_off_peak_9,
            final double Ferry_off_peak_NS_0_3,


            final double Ferry_fare_0_9,
            final double Ferry_fare_9,
            final double Ferry_fare_NS_0_3,


            //Light rail fares
            final double Light_rail_single_0_3,
            final double Light_rail_single_3_8,
            final double Light_rail_single_8,


            final double Light_rail_off_peak_0_3,
            final double Light_rail_off_peak_3_8,
            final double Light_rail_off_peak_8,


            final double Light_rail_fare_0_3,
            final double Light_rail_fare_3_8,
            final double Light_rail_fare_8



    ) {
        this.fareId = fareId;
        this.daily_weekly_min = daily_weekly_min;
        this.daily_weekly_max = daily_weekly_max;
        this.daily_weekly_weekends = daily_weekly_weekends;
        this.metro_train_single_0_10 = metro_train_single_0_10;
        this.metro_train_single_10_20 = metro_train_single_10_20;
        this.metro_train_single_20_35 = metro_train_single_20_35;
        this.metro_train_single_35_65 = metro_train_single_35_65;
        this.metro_train_single_65 = metro_train_single_65;
        this.metro_train_off_peak_0_10 = metro_train_off_peak_0_10;
        this.metro_train_off_peak_10_20 = metro_train_off_peak_10_20;
        this.metro_train_off_peak_20_35 = metro_train_off_peak_20_35;
        this.metro_train_off_peak_35_65 = metro_train_off_peak_35_65;
        this.metro_train_off_peak_65 = metro_train_off_peak_65;
        this.metro_train_fare_0_10 = metro_train_fare_0_10;
        this.metro_train_fare_10_20 = metro_train_fare_10_20;
        this.metro_train_fare_20_35 = metro_train_fare_20_35;
        this.metro_train_fare_35_65 = metro_train_fare_35_65;
        this.metro_train_fare_65 = metro_train_fare_65;

        this.Bus_single_0_3 = Bus_single_0_3;
        this.Bus_single_3_8 = Bus_single_3_8;
        this.Bus_single_8 = Bus_single_8;
        this.Bus_off_peak_0_3 = Bus_off_peak_0_3;
        this.Bus_off_peak_3_8 = Bus_off_peak_3_8;
        this.Bus_off_peak_8 = Bus_off_peak_8;
        this.Bus_fare_0_3 = Bus_fare_0_3;
        this.Bus_fare_3_8 = Bus_fare_3_8;
        this.Bus_fare_8 = Bus_fare_8;


        this.Ferry_single_0_9 = Ferry_single_0_9;
        this.Ferry_single_9 = Ferry_single_9;
        this.Ferry_single_NS_0_3 = Ferry_single_NS_0_3;

        this.Ferry_off_peak_0_9 = Ferry_off_peak_0_9;
        this.Ferry_off_peak_9 = Ferry_off_peak_9;
        this.Ferry_off_peak_NS_0_3 = Ferry_off_peak_NS_0_3;

        this.Ferry_fare_0_9 = Ferry_fare_0_9;
        this.Ferry_fare_9 = Ferry_fare_9;
        this.Ferry_fare_NS_0_3 = Ferry_fare_NS_0_3;


        this.Light_rail_single_0_3 = Light_rail_single_0_3;
        this.Light_rail_single_3_8 = Light_rail_single_3_8;
        this.Light_rail_single_8 = Light_rail_single_8;

        this.Light_rail_off_peak_0_3 = Light_rail_off_peak_0_3;
        this.Light_rail_off_peak_3_8 = Light_rail_off_peak_3_8;
        this.Light_rail_off_peak_8 = Light_rail_off_peak_8;

        this.Light_rail_fare_0_3 = Light_rail_fare_0_3;
        this.Light_rail_fare_3_8 = Light_rail_fare_3_8;
        this.Light_rail_fare_8 = Light_rail_fare_8;

    }

    public Fares(Document document) {
        this.objectId = new ObjectId(document.get("_id").toString());
        this.fareId = UUID.fromString(document.getString("fare_id"));
        this.daily_weekly_min = document.getDouble("dw_min");
        this.daily_weekly_max = document.getDouble("dw_max");
        this.daily_weekly_weekends = document.getDouble("dw_weekends");
        //metro train
        this.metro_train_single_0_10 = document.getDouble("mts_0_10");
        this.metro_train_single_10_20 = document.getDouble("mts_10_20");
        this.metro_train_single_20_35 = document.getDouble("mts_20_35");
        this.metro_train_single_35_65 = document.getDouble("mts_35_65");
        this.metro_train_single_65 = document.getDouble("mts_65");

        this.metro_train_off_peak_0_10 = document.getDouble("mtp_0_10");
        this.metro_train_off_peak_10_20 = document.getDouble("mtp_10_20");
        this.metro_train_off_peak_20_35 = document.getDouble("mtp_20_35");
        this.metro_train_off_peak_35_65 = document.getDouble("mtp_35_65");
        this.metro_train_off_peak_65 = document.getDouble("mtp_65");

        this.metro_train_fare_0_10 = document.getDouble("mtf_0_10");
        this.metro_train_fare_10_20 = document.getDouble("mtf_10_20");
        this.metro_train_fare_20_35 = document.getDouble("mtf_20_35");
        this.metro_train_fare_35_65 = document.getDouble("mtf_35_65");
        this.metro_train_fare_65 = document.getDouble("mtf_65");

        //Bus
        this.Bus_single_0_3 = document.getDouble("bss_0_3");
        this.Bus_single_3_8 = document.getDouble("bss_3_8");
        this.Bus_single_8 = document.getDouble("bss_8");


        this.Bus_off_peak_0_3 = document.getDouble("bsp_0_3");
        this.Bus_off_peak_3_8 = document.getDouble("bsp_3_8");
        this.Bus_off_peak_8 = document.getDouble("bsp_8");


        this.Bus_fare_0_3 = document.getDouble("bsf_0_3");
        this.Bus_fare_3_8 = document.getDouble("bsf_3_8");
        this.Bus_fare_8 = document.getDouble("bsf_8");


        //ferry
        this.Ferry_single_0_9 = document.getDouble("fys_0_9");
        this.Ferry_single_9 = document.getDouble("fys_9");
        this.Ferry_single_NS_0_3 = document.getDouble("fys_ns_0_3");


        this.Ferry_off_peak_0_9 = document.getDouble("fyp_0_9");
        this.Ferry_off_peak_9 = document.getDouble("fyp_9");
        this.Ferry_off_peak_NS_0_3 = document.getDouble("fyp_ns_0_3");


        this.Ferry_fare_0_9 = document.getDouble("fyf_0_9");
        this.Ferry_fare_9 = document.getDouble("fyf_9");
        this.Ferry_fare_NS_0_3 = document.getDouble("fyf_ns_0_3");


        //Light rail

        this.Light_rail_single_0_3 = document.getDouble("lrs_0_3");
        this.Light_rail_single_3_8 = document.getDouble("lrs_3_8");
        this.Light_rail_single_8 = document.getDouble("lrs_8");


        this.Light_rail_off_peak_0_3 = document.getDouble("lrp_0_3");
        this.Light_rail_off_peak_3_8 = document.getDouble("lrp_3_8");
        this.Light_rail_off_peak_8 = document.getDouble("lrp_8");


        this.Light_rail_fare_0_3 = document.getDouble("lrf_0_3");
        this.Light_rail_fare_3_8 = document.getDouble("lrf_3_8");
        this.Light_rail_fare_8 = document.getDouble("lrf_8");

    }


    public Document convertClassToDocument() {
        return new Document("fare_id", fareId.toString())
                .append("dw_min", daily_weekly_min)
                .append("dw_max", daily_weekly_max)
                .append("dw_weekends", daily_weekly_weekends)
                .append("mts_0_10", metro_train_single_0_10)
                .append("mts_10_20", metro_train_single_10_20)
                .append("mts_20_35", metro_train_single_20_35)
                .append("mts_35_65", metro_train_single_35_65)
                .append("mts_65", metro_train_single_65 )
                .append("mtp_0_10", metro_train_off_peak_0_10)
                .append("mtp_10_20", metro_train_off_peak_10_20)
                .append("mtp_20_35", metro_train_off_peak_20_35 )
                .append("mtp_35_65", metro_train_off_peak_35_65)
                .append("mtp_65", metro_train_off_peak_65)
                .append("mtf_0_10", metro_train_fare_0_10)
                .append("mtf_10_20", metro_train_fare_10_20)
                .append("mtf_20_35", metro_train_fare_20_35 )
                .append("mtf_35_65", metro_train_fare_35_65)
                .append("mtf_65", metro_train_fare_65)
                .append("bss_0_3", Bus_single_0_3)
                .append("bss_3_8", Bus_single_3_8)
                .append("bss_8", Bus_single_8)
                .append("bsp_0_3", Bus_off_peak_0_3)
                .append("bsp_3_8", Bus_off_peak_3_8)
                .append("bsp_8", Bus_off_peak_8 )
                .append("bsf_0_3", Bus_fare_0_3)
                .append("bsf_3_8", Bus_fare_3_8)
                .append("bsf_8", Bus_fare_8 )
                .append("fys_0_9", Ferry_single_0_9)
                .append("fys_9", Ferry_single_9)
                .append("fys_ns_0_3", Ferry_single_NS_0_3)
                .append("fyp_0_9", Ferry_off_peak_0_9)
                .append("fyp_9", Ferry_off_peak_9)
                .append("fyp_ns_0_3", Ferry_off_peak_NS_0_3)
                .append("fyf_0_9", Ferry_fare_0_9)
                .append("fyf_9", Ferry_fare_9)
                .append("fyf_ns_0_3", Ferry_fare_NS_0_3 )
                .append("lrs_0_3", Light_rail_single_0_3)
                .append("lrs_3_8", Light_rail_single_3_8)
                .append("lrs_8", Light_rail_single_8)
                .append("lrp_0_3", Light_rail_off_peak_0_3)
                .append("lrp_3_8", Light_rail_off_peak_3_8)
                .append("lrp_8", Light_rail_off_peak_8 )
                .append("lrf_0_3", Light_rail_fare_0_3)
                .append("lrf_3_8", Light_rail_fare_3_8)
                .append("lrf_8", Light_rail_fare_8);
    }



}
