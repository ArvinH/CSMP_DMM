package CSMP.DMM.service.servlet;

import CSMP.DMM.service.servlet.token_verification;

public class test_client_MTM {
	public static void main(String arg[]){
		
		token_verification tt = new token_verification();
		
		String Token = ",MIIEpQIBAAKCAQEAntP7LTpbPf/86kEbmgPo/cS7DrD/koNCG0eIxQibBeCSdGcW,fylnK3mNlhn2WSJs8HuR/RIlyfYAh6quC5p1EPnCMWVDWUkqGOdgHQhs4gzJv8XF,6wDjUN99C7WGIYwjc0BLpxJJfRj8CfM04KHrPVXGu3Gduaxcwb4Za74fn5k4+X8x,b6/BAZfoWfUJn9MdU5F0Vx4srG+xLPw4Ei6/MhQoDPzZVhYSiW0OGn4SCmhmEGw8,rc/SFmLVwd60kNxLEQuSpjYHFw4GgrFnN/CAYs0ZGyCyWwNb8BgCWTlfkLdmX5R9,rLqFQAjVR22itKsv3EqvpklltkUP+0M4N9wR7QIDAQABAoIBAE5nlrbc9+3DULbT,LSz6gSnE1BKMjZ1l7lxJE9swRFbCZYnQ2eosJiHv/1T5vAKEXALa/VZQfxcTuW8/,cmuH9AJNSO/ZbUXGOGHS1j9+yUFNzso8d1drOMvTh4cgNPaal2Vtd+shu+VlUAYZ,aSD6zYWZsmEV1SazT5bUoPfvAu1ljtRqQhktVNqW4b3uQTVXQ+hSETcFKQeBJQiA,GtgJu85APSbj4PkuwYxoerKcPWd47sHYaF7Tz9+jg5HsoMCVoCsLVBsh/j+mR5A5,hVY2KkBJ4DS8lzuoUbwYVh+Fw+OFcs76tswsuD5aFVxTC54cbIxHvpRf04NqcHTB,WGlPkAECgYEA0qtY3vQ0r5WwjjFGttcNQeOeoF3sBc+S9+9Br3203ejXntZbA4nN,IzjhIlmY8R1qVPnQVGRUNTIH35QTZM21awqalOPuBwQYJ17OInon3jPN6GoykBTk,qpIzx/D5J3BigS5RbxERoFH1B46oyyczQIngKgWQW/i215+823J8gCECgYEAwQD5,Uzb9naPFc1DQxHL+H877vd8w4qXViM0B6eBnfdYOG4PavwgsHCwBGmJDtERtjvox,OSHCJLbgYV9Ly/x0WlKRaNFMnEtkN1WCXrKtiTDdAJdhgUptlv9c3gxd0YA54Lnk,Dkzh1SSgb1k9kAKkq2Q72DTdsRb03jgv6XlYiE0CgYEAlw5l2vggDwa2Yj7TBaeN,ygD8bODrq/760uyrnLn2Rmf+s9XfzNmyTd8rDwZPtBPzeprl1p1aBAqrupTikxUt,UGN6E+ibdExrRU+lXvNYQuvCaTQ8rTNOA0ByAJu5C556A0bC/XCvwtUBbTnNrl2d,UlmKcpcqu8fK0zGmqXOd8gECgYEAt7xrntK9AjOEp1EKTdqDHlj3wzwU18+zxvYT,mkitfVgoOf1+Y1ouU+t4aVuexKBYBEMeVRtULYuDdG86Q0lkow/zqeuGmUwUbbET,2X8UQYSpAAUdJ+5pAdS83g67ydPeRZfyCcMbQsQJj7dPKie6CAf2CM/bNNl754lp,40RICgkCgYEAzOaOKSX01JH+q+1UZD3+829FzmeDwzmmutY2J4AwqSFWILH3vAFb,Vi+mU3bbw7Bx49wgc/PKiOC8aAPQx7loCbDhko/hey8gR4yhqhGzopfGhfsHRsy4,kOdaoOqJIkeXydGdfJGgLeAyIeWDsRp/Pt/c8Evw5mVctpK64IdFmIU=,";
		String SME_ID = "79";
		
	
		String token_verification_status = tt.send(SME_ID,Token);
		System.out.println(token_verification_status);
		System.out.println("token_verification is " + ((token_verification_status.equals("1"))?"OK":"ERROR"));
	}
}

