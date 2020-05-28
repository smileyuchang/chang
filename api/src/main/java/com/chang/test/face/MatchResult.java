package com.chang.test.face;

import java.util.List;

public class MatchResult {

    /**
     * error_code : 0
     * error_msg : SUCCESS
     * log_id : 15565799499
     * timestamp : 1590396985
     * cached : 0
     * result : {"score":97.83485413,"face_list":[{"face_token":"2db6d5b006723f5a2ffab43b40f93d63"},{"face_token":"d215903637e0d4a8bafa39532d9d9f39"}]}
     */

    private int error_code;
    private String error_msg;
    private long log_id;
    private int timestamp;
    private int cached;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * score : 97.83485413
         * face_list : [{"face_token":"2db6d5b006723f5a2ffab43b40f93d63"},{"face_token":"d215903637e0d4a8bafa39532d9d9f39"}]
         */

        private double score;
        private List<FaceListBean> face_list;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<FaceListBean> getFace_list() {
            return face_list;
        }

        public void setFace_list(List<FaceListBean> face_list) {
            this.face_list = face_list;
        }

        public static class FaceListBean {
            /**
             * face_token : 2db6d5b006723f5a2ffab43b40f93d63
             */

            private String face_token;

            public String getFace_token() {
                return face_token;
            }

            public void setFace_token(String face_token) {
                this.face_token = face_token;
            }
        }
    }
}
