using System;
using System.Collections.ObjectModel;

using System.Windows;
using System.Windows.Input;
using TestCreator.Objects;
using TestCreator.TestCreatorAPI;

namespace TestCreator
{
    /// <summary>
    /// Логика взаимодействия для GroupViewWindow.xaml
    /// </summary>
    public partial class GroupViewWindow : Window
    {
        private UserGroup userGroup;
        public ObservableCollection<User> subscribers = new ObservableCollection<User>();
        public ObservableCollection<Test> tests = new ObservableCollection<Test>();

        public GroupViewWindow()
        {
            InitializeComponent();
            listSubscribers.ItemsSource = subscribers;
            listTests.ItemsSource = tests;
        }

        public void init(UserGroup userGroup)
        {
            this.userGroup = userGroup;

            ObservableCollection<User> users = Client.getuserByGroup(userGroup.group);
            groupName.Content = userGroup.group.name;
            foreach (Test test in userGroup.group.tests)
            {
                tests.Add(test);
            }
            foreach (User user in users)
            {
                subscribers.Add(user);
            }

            invitationLink.Content = "Ссылка-приглашение: " + userGroup.group.invitationLink;
            if (!userGroup.is_admin)
            {
                button_publish_test.IsEnabled = false;
                delete_test_from_group.IsEnabled = false;
                deleteGroup.Content = "Покинуть группу";


            }
            if (userGroup.group.security_status == Group.Security.Private && !userGroup.is_admin)
            {
                copyLink.IsEnabled = false;
                invitationLink.Content = "Ой, только админ может приглашать в группу";
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (userGroup.is_admin)
            {
                Client.deleteGroup(userGroup.group.id_group);
            }
            else
            {
                long id = Client.getIdByUserAndGroup(userGroup);
                Client.deleteuserGroup(id);
            }
            MainWindow.groups.Remove(userGroup);
            Close();
        }


        private void copyLink_Click_CopyLink(object sender, RoutedEventArgs e)
        {
            try
            {
                Clipboard.Clear();
                Clipboard.SetText(userGroup.group.invitationLink);
            }
            catch (Exception ww) {
                MessageBox.Show(ww.ToString());
            }
            
        }

        private void listSubscribers_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            if (listSubscribers.SelectedItem != null)
            {
                User user = listSubscribers.SelectedItem as User;
                MyProfileWindow window = new MyProfileWindow();
                window.init(user, userGroup.user);
                MainWindow.winds.Add(window);
                window.Show();
            }
        }

        private void Button_Click_addTest(object sender, RoutedEventArgs e)
        {
            ChooseTestWindow window = new ChooseTestWindow();
            //window.setData(userGroup, this);
           // window.Show();
            //MainWindow.winds.Add(window);
        }

        private void delete_test_from_group_Click(object sender, RoutedEventArgs e)
        {
            if (listTests.SelectedItem != null)
            {
                Test test = listTests.SelectedItem as Test;
                tests.Remove(test);
                userGroup.group.tests.Remove(test);
                Client.updateGroup(userGroup.group, userGroup.group.id_group);
            }
        }

        private void listTests_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            if (listTests.SelectedItem != null)
            {
                ViewTest window = new ViewTest();
                window.init(userGroup.user);
                window.Show();
                MainWindow.winds.Add(window);
                window.loadTest(listTests.SelectedItem as Test);
            }
        }
    }
}
