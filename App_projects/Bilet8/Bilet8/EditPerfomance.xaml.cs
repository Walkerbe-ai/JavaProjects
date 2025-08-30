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
using System.Xml.Linq;

namespace Bilet8
{
    /// <summary>
    /// Логика взаимодействия для EditPerfomance.xaml
    /// </summary>
    public partial class EditPerfomance : Page
    {
        string jsonTicket, jsonPerfomance;
        List<Perfomance> perfomance;
        List<Ticket> tickets1;
        public EditPerfomance(Perfomance perfomance)
        {
            InitializeComponent();
            datePerfomance.DisplayDateStart = DateTime.Now;
            datePerfomance.DisplayDateEnd = DateTime.Now.AddDays(31);
            IdPerfomance.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, OnPasteCommand));
            namePerfomance.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, OnPasteCommand));
            datePerfomance.CommandBindings.Add(new CommandBinding(ApplicationCommands.Paste, OnPasteCommand));
            IdPerfomance.Text = perfomance.idPerfomance;
            namePerfomance.Text = perfomance.namePerfomance;
            datePerfomance.Text = perfomance.datePerfomance;
            jsonTicket = File.ReadAllText(@"ticket.json");
            List<Ticket> tickets = JsonConvert.DeserializeObject<List<Ticket>>(jsonTicket);
            tickets1 = new List<Ticket>();
            foreach (var item in tickets)
            {
                if (item.idPerfomance == perfomance.idPerfomance)
                {
                    tickets1.Add(item);
                }
            }
            ticketListView.ItemsSource = tickets1;
            idPerfomance123 = IdPerfomance.Text;
        }
        string idPerfomance123;
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
                jsonPerfomance = File.ReadAllText(@"perfomance.json");
                perfomance = JsonConvert.DeserializeObject<List<Perfomance>>(jsonPerfomance);
                foreach (var item in perfomance)
                {
                    if (item.idPerfomance.Contains(idPerfomance123))
                    {
                        item.idPerfomance = IdPerfomance.Text;
                        item.namePerfomance = namePerfomance.Text.Trim();
                        item.datePerfomance = datePerfomance.Text;
                    }
                }
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

        private void Viewbox_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            int i = 0;
            jsonTicket = File.ReadAllText(@"ticket.json");
            List<Ticket> tickets = JsonConvert.DeserializeObject<List<Ticket>>(jsonTicket);
            foreach (var item in tickets)
            {
                if (ticketListView.SelectedIndex == i)
                {
                    this.NavigationService.Navigate(new EditTicket(item));
                }
                i++;
            }
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            jsonPerfomance = File.ReadAllText(@"perfomance.json");

            perfomance = JsonConvert.DeserializeObject<List<Perfomance>>(jsonPerfomance);

            jsonTicket = File.ReadAllText(@"ticket.json");
            List<Ticket> tickets = JsonConvert.DeserializeObject<List<Ticket>>(jsonTicket);
            foreach (var item in perfomance)
            {
                if (IdPerfomance.Text == item.idPerfomance)
                {
                    perfomance.Remove(item);
                    var convertedJson = JsonConvert.SerializeObject(perfomance, Formatting.Indented);
                    File.WriteAllText("perfomance.json", convertedJson);
                    tickets.RemoveAll(r => r.idPerfomance == IdPerfomance.Text);
                    var convertedJson1 = JsonConvert.SerializeObject(tickets, Formatting.Indented);
                    File.WriteAllText("ticket.json", convertedJson1);
                    this.NavigationService.Navigate(new Add());
                    break;
                }
            }

            


        }
    }
}
