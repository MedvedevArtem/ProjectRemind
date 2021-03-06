package adapterTabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.ExampleFragment;

public class TabsPagerFragment extends FragmentPagerAdapter{

    private String[] tabs;

    public TabsPagerFragment(FragmentManager fm) {
        super(fm);
        tabs  = new String[] {
                "Tab 1",
                "Notification",
                "tab 3"
        };
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExampleFragment.getInstance();
            case 1:
                return ExampleFragment.getInstance();
            case 2:
                return ExampleFragment.getInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
