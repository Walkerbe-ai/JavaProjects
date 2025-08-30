using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Bilet8
{
    /// <summary>
    /// Логика взаимодействия для Add.xaml
    /// </summary>
    public partial class Add : Page
    {
        string jsonPerfomance;
        public Add()
        {
            InitializeComponent();
            jsonPerfomance = File.ReadAllText(@"perfomance.json");
            List<Perfomance> perfomance = JsonConvert.DeserializeObject<List<Perfomance>>(jsonPerfomance);
            perfomanceListView.ItemsSource = perfomance;

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            this.NavigationService.Navigate(new PerformanceAdd());
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            this.NavigationService.Navigate(new TicketAdd());
        }

        private void Viewbox_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            int i = 0;
            jsonPerfomance = File.ReadAllText(@"perfomance.json");
            List<Perfomance> passangers1 = JsonConvert.DeserializeObject<List<Perfomance>>(jsonPerfomance);
            foreach (var item in passangers1)
            {
                if (perfomanceListView.SelectedIndex == i)
                {
                    this.NavigationService.Navigate(new EditPerfomance(item));
                }
                i++;
            }
        }
    }
}
