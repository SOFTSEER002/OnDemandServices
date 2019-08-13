package com.example.ondemandapp.modelclass;

public class MembershipReviewModel {
    String membername,member_salontype,member_quote,member_reviewdon;

    public MembershipReviewModel(String membername, String member_salontype, String member_quote, String member_reviewdon) {
       this.setMembername(membername);
       this.setMember_salontype(member_salontype);
       this.setMember_quote(member_quote);
       this.setMember_reviewdon(member_reviewdon);
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMember_salontype() {
        return member_salontype;
    }

    public void setMember_salontype(String member_salontype) {
        this.member_salontype = member_salontype;
    }

    public String getMember_quote() {
        return member_quote;
    }

    public void setMember_quote(String member_quote) {
        this.member_quote = member_quote;
    }

    public String getMember_reviewdon() {
        return member_reviewdon;
    }

    public void setMember_reviewdon(String member_reviewdon) {
        this.member_reviewdon = member_reviewdon;
    }
}
