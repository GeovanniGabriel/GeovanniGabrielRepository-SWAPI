package com.geovanni.starwars.app.Bussiness.Interfaces;

/**
 * Created by gabri on 17/07/2017.
 */

public interface IToolbarListener {

    class ToolbarSettings {

        private int color;
        private boolean showSeparator;
        private String tag;

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public boolean isShowSeparator() {
            return showSeparator;
        }

        public void setShowSeparator(boolean showSeparator) {
            this.showSeparator = showSeparator;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }

    void updateToolbar(String title, ToolbarSettings settings, String tag);
}
