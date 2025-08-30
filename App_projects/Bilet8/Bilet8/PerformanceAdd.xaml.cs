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
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Bilet8
{
    /// <summary>
    /// Логика взаимодействия для PerformanceAdd.xaml
    /// </summary>
    public partial class PerformanceAdd : Page
    {
        
        public PerformanceAdd()
        {
            InitializeComponent();
            datePerfomance.DisplayDateStart = DateTime.Now;
            datePerfomance.DisplayDateEnd = DateTime.Now.AddDays(31);
            IdPerfomance.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, OnPasteCommand));
            namePerfomance.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, OnPasteCommand));
            datePerfomance.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, OnPasteCommand));

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (IdPerfomance.Text.Length == 0)
            {
                MessageBox.Show("Введите код спектакля");
                return;
            }
            if (namePerfomance.Text.Length == 0)
            {
                MessageBox.Show("Введите название спектакля");
                return;
            }
            if (datePerfomance.Text.Length == 0)
            {
                MessageBox.Show("Введите дату покупки спектакля");
                return;
            }
            else
            {
                string perfomanceJ = File.ReadAllText(@"perfomance.json");
                List<Perfomance> perfomance = JsonConvert.DeserializeObject<List<Perfomance>>(perfomanceJ);
                foreach (var item in perfomance)
                {
                    if (item.idPerfomance == IdPerfomance.Text)
                    {
                        MessageBox.Show("Код спектакля уже использован");
                        return;
                    }
                }
                perfomance.Add(new Perfomance
                {
                    idPerfomance = IdPerfomance.Text,
                    namePerfomance = namePerfomance.Text.Trim(),
                    datePerfomance = datePerfomance.Text,
                });
                string Jfile = JsonConvert.SerializeObject(perfomance, Formatting.Indented);
                File.WriteAllText("perfomance.json", Jfile);
                this.NavigationService.Navigate(new Add());
            } 
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            this.NavigationService.Navigate(new Add());
        }
        public void OnPasteCommand(object sender, ExecutedRoutedEventArgs e)
        {

        }

        private void IdPerfomance_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {
                e.Handled = true;
            }
        }

        private void IdPerfomance_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            if (!Char.IsDigit(e.Text, 0)) e.Handled = true;
        }

        private void dateBuyPerfomance_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            e.Handled = true;
        }

        private void dateBuyPerfomance_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {
                e.Handled = true;
            }
        }
    }
}
