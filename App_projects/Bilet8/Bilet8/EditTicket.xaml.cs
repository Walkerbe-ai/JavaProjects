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
    /// Логика взаимодействия для EditTicket.xaml
    /// </summary>
    public partial class EditTicket : Page
    {
        public EditTicket(Ticket ticket)
        {
            InitializeComponent();
            dateBuyTicket.DisplayDateStart = DateTime.Now;
            dateBuyTicket.DisplayDateEnd = DateTime.Now.AddDays(31);
            tickets123 = IdPerfomance.Text;
            IdPerfomance.Text = ticket.idPerfomance;
            numberTicket.Text = ticket.numberTicket;
            dateBuyTicket.Text = ticket.dateBuyTicket;
        }
        string tickets123;
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (IdPerfomance.Text.Length == 0)
            {
                MessageBox.Show("Введите код спектакля");
                return;
            }
            if (numberTicket.Text.Length == 0)
            {
                MessageBox.Show("Введите номер билета");
                return;
            }
            if (dateBuyTicket.Text.Length == 0)
            {
                MessageBox.Show("Введите дату покупки билета");
                return;
            }
            else
            {
                string ticketJ = File.ReadAllText(@"ticket.json");
                List<Ticket> tickets = JsonConvert.DeserializeObject<List<Ticket>>(ticketJ);
                foreach (var item in tickets)
                {
                    if (item.idPerfomance.Contains(tickets123))
                    {
                        item.idPerfomance = IdPerfomance.Text;
                        item.numberTicket = numberTicket.Text.Trim();
                        item.dateBuyTicket = dateBuyTicket.Text;
                    }
                }
                string Jfile = JsonConvert.SerializeObject(tickets, Formatting.Indented);
                File.WriteAllText("ticket.json", Jfile);
                this.NavigationService.Navigate(new Add());
            }
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            this.NavigationService.Navigate(new Add());
        }

        private void numberTicket_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            if (!Char.IsDigit(e.Text, 0)) e.Handled = true;
        }
        public void OnPasteCommand(object sender, ExecutedRoutedEventArgs e)
        {

        }

        private void IdTicket_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            if (!Char.IsDigit(e.Text, 0)) e.Handled = true;
        }

        private void dateBuyTicket_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            e.Handled = true;
        }

        private void IdTicket_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {
                e.Handled = true;
            }
        }

        private void numberTicket_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {
                e.Handled = true;
            }
        }

        private void dateBuyTicket_PreviewKeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Space)
            {
                e.Handled = true;
            }
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {

        }
    }
}
